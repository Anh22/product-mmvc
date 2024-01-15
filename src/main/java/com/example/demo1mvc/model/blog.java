package com.example.demo1mvc.model;

import javax.persistence.*;

@Entity
public class blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String content;

    private double title;
    @ManyToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public blog() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getTitle() {
        return title;
    }

    public void setTitle(double title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "blog{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title=" + title +
                '}';
    }

    public blog(int id, String content, double title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }
}
