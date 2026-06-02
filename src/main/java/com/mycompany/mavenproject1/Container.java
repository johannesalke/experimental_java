/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;

/**
 *
 * @author johan
 */
public class Container {
    public String label;
    public Integer capacity;
    public ArrayList<String> lines;
    
    public Container(String s,Integer capacity){
        this.label = s;
        this.capacity = capacity;
        this.lines = new ArrayList<>();
    }
    public void store(String line) {
        this.lines.add(line);
    }
    public Boolean space_left() {
        
            return (this.lines.size() < this.capacity);
    }
    public ArrayList<String> contents(){
        return this.lines;
    }
}
