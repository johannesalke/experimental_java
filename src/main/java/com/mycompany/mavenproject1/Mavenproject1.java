/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;


public class Mavenproject1 extends Application {

    public static void main(String[] args) {
        
        //BasicExperiments.experiment_read_file_into_object();
        //BasicExperiments.experiment_assigning_references();
        //BasicExperiments.experiment_hashmaps();
        //BasicExperiments.experiment_custom_equals();
        //BasicExperiments.experiment_custom_hashcodes();
        //BasicExperiments.experiment_generics_and_interfaces();
        //BasicExperiments.experiment_streams_one();

        //BasicExperiments.experiment_comparable_containers();
        //BasicExperiments.experiment_stream_lambda_sorting();
        //BasicExperiments.experiment_enum();
        //BasicExperiments.experiment_iterator();
        //BasicExperiments.experiment_imported_package();
        //BasicExperiments.experiment_exceptions();
        //BasicExperiments.experiment_make_file();
        launch(Mavenproject1.class);

    }


    //I don't like putting other stuff in the main function of an experimental project, but it's unavoidable here.
    //Using javafx requires that the main function extends the application class.
    @Override
    public void start(Stage window) {
        window.setTitle("Hello World!");
        window.show();
    }

}
