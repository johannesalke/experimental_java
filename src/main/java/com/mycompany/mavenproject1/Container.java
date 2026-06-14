/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;

/**
 *
 * @author johan
 * @param <T>
 */
public class Container<T> implements Stack<T>, Comparable<Container<T>>{
    public String label;
    public Integer capacity;
    public ArrayList<T> items;
    
    public Container(String s,Integer capacity){
        this.label = s;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    public void store(T line) {
        this.items.add(line);
    }
    public Boolean space_left() {
        
            return (this.items.size() < this.capacity);
    }
    public ArrayList<T> contents(){
        return this.items;
    }
    
    @Override
    public void push(T item) {
        this.store(item);
    }
    
    @Override
    public T pop(){
        
        return this.items.removeLast();
    }
    
    @Override
    public int size(){
        return this.items.size();
    }
    
    @Override
    public int compareTo(Container<T> other) {
        return this.items.size() - other.items.size();
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
            this.items.equals(other.items)) {
            return true;
        }
        return false;
    
    }
    
    @Override
    public int hashCode() {
        return this.label.hashCode();
    }
    
    
}



