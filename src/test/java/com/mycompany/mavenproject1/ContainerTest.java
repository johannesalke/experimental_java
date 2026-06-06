/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author johan
 */
public class ContainerTest {
    
    public ContainerTest() {
    }

   
    

    /**
     * Test of store method, of class Container.
     */
    @Test
    public void testStore() {
        System.out.println("Test: store");
        String line = "";
        Container instance = new Container("test",5);
        instance.store(line);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of space_left method, of class Container.
     */
    @Test
    public void testSpace_left() {
        System.out.println("space_left");
        Container instance = new Container("test",5);
        Boolean expResult1 = true;
        Boolean expResult2 = false;
        Boolean result = instance.space_left();
        assertEquals(expResult1, result);
        String state = fillContainer(instance);
        result = instance.space_left();
        assertEquals(state, "full");
        assertEquals(expResult2, result);

        // TODO review the generated test code and remove the default call to fail.
        //fail("Test of the spaceLeft function has failed.");
    }

    /**
     * Test of contents method, of class Container.
     */
    /*
    @Test
    public void testContents() {
        System.out.println("contents");
        Container instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.contents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
    
    public String fillContainer(Container container) {
        try(Scanner scanner = new Scanner(Paths.get("file.txt"));) {
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (container.space_left()) {
                    container.store(line);
                    
                } else {
                    return("full");
                    
                }
                
            }
            

            
        } catch (Exception e){
            return("error");
        }
        return("not full");
    }
    
}
