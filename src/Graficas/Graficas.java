/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficas;

import IO.Totales;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author David Alcocer
 */
public class Graficas {

    public static CategoryDataset edad(Totales estadisticas) {
        DefaultCategoryDataset datos = new DefaultCategoryDataset(); // se crea el 
        //repositorios para asignarle datos
        datos.addValue(estadisticas.totalMayorEdad(), "Mayor edad", "Mayores");
        datos.addValue(estadisticas.totalMenorEdad(), "Menor edad", "Menores");
        return datos;
    }

    public static CategoryDataset sexo(Totales estadisticas) {
        DefaultCategoryDataset datos = new DefaultCategoryDataset(); // se crea el 
        //repositorios para asignarle datos
        datos.addValue(estadisticas.totalHombres(), "Hombre", "Hombres");
        datos.addValue(estadisticas.totalMujeres(), "Mujer", "Mujeheres");
        return datos;
    }

    public static CategoryDataset civil(Totales estadisticas) {
        DefaultCategoryDataset datos = new DefaultCategoryDataset(); // se crea el 
        //repositorios para asignarle datos
        datos.addValue(estadisticas.totalSolteros(), "Soltero", "Solteros");
        datos.addValue(estadisticas.totalCasados(), "Casado", "Casados");
        datos.addValue(estadisticas.totalViudos(), "Viudo", "Viudos");
        datos.addValue(estadisticas.totalDivorciados(), "Divorciado", "Divorciados");
        return datos;
    }

    public static PieDataset porcentaje(Totales estadisticas) {
        DefaultPieDataset edad = new DefaultPieDataset();
        edad.setValue("Hombres", estadisticas.porcentajeHombres());
         edad.setValue("Mujeres", estadisticas.porcentajeMujeres());
        return edad;
    }
    public static void  crearGraficas(CategoryDataset datosEdad,CategoryDataset
            datosSexo,CategoryDataset datosCivil,PieDataset porcentaje,Totales total){
        JFreeChart graficaEdad,graficaSexo,graficaCivil,graficaPorcentajes;
        graficaEdad=ChartFactory.createBarChart("Edades", "",
                "Total", datosEdad);
        graficaSexo=ChartFactory.createBarChart("Sexos", "", 
                "Total", datosSexo);
        graficaCivil=ChartFactory.createBarChart("Estado Civil", "", 
                "Total", datosCivil);
        graficaPorcentajes=ChartFactory.createPieChart("Porcentaje de asistencia",
                porcentaje);
        
        crearPanel(graficaEdad, graficaSexo, graficaCivil, graficaPorcentajes,
                total.totalAsistentes());
    }
    public static void crearPanel(JFreeChart edad,JFreeChart sexo,JFreeChart
            civil,JFreeChart porcentajes,int total){
        ChartPanel edades= new ChartPanel(edad);
        ChartPanel sexos= new ChartPanel(sexo);
        ChartPanel estados= new ChartPanel(civil);
        ChartPanel porcentaje= new ChartPanel(porcentajes);
        JFrame frame= new JFrame("Total de Asistentes: "+total);
        frame.setLayout(new GridLayout(2,2,15,15));
        frame.add(edades);
        frame.add(sexos);
        frame.add(estados);
        frame.add(porcentaje);
        frame.pack();
        frame.setVisible(true);

    }
}