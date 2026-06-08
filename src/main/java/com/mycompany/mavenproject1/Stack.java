/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author johan
 * @param <T>
 */
public interface Stack<T> {
    void push(T item);
    
    
    public T pop();
    
    int size();
    
}
