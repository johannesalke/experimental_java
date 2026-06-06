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
    
    @Override
    public boolean equals(Object obj){
        if (obj == this) {
        return true;
                
        }
        if (!(obj instanceof Container)) {
            return false;
        }
        
        Container other = (Container) obj;
        
        if (this.label.equals( other.label)  &&
            this.capacity.equals(other.capacity)&&
            this.lines.equals(other.lines)) {
            return true;
        }
        return false;
    
    }
    
    @Override
    public int hashCode() {
        return this.label.hashCode();
    }
}
