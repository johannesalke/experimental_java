/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author johan
 */
public class ShippingContainer extends Container {
    public String shipname;
    public ShippingContainer (String label, Integer size, String shipname) {
        super(label,size);
        this.shipname = shipname;
    }
}
