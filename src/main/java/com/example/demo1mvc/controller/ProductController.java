package com.example.demo1mvc.controller;

import com.example.demo1mvc.model.Product;
import com.example.demo1mvc.reposity.ProductReposity;
import com.example.demo1mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductReposity productReposity;


    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("list", productReposity.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(Model model) {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productReposity.save(product);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("item", productReposity.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productReposity.deleteById(id);
        return "redirect:/products";
    }
    @GetMapping("/search")
    public String searchProducts(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Product> searchResults;

        if (name != null && !name.isEmpty()) {
            searchResults = productReposity.findByNameContainingIgnoreCase(name);
        } else {
            searchResults = productReposity.findAll();
        }

        model.addAttribute("list", searchResults);
        model.addAttribute("searchTerm", name);

        return "/product/list";
    }
}