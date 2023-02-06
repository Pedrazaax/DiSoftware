package edu.uclm.esi.ds.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class LanzaderaApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(LanzaderaApp.class, args);
    }
}
