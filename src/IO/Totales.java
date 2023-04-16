package IO;
import TDA.Asistentes;
import java.util.ArrayList;

public class Totales {
    ArrayList<Asistentes> asistentes = new ArrayList<>();
    
    private Asistentes crear () {
        Asistentes aux = new Asistentes();
        aux.setNombre("");
        aux.setEdad((byte)0);
        aux.setSexo("");
        aux.setEstadoCivil("");
        return aux;
    }
    public void registrar () {
        asistentes.add(crear());
    }
    
    // Metodos Total
    public int totalAsistentes () {
        return asistentes.size();
    }
    public int tamArr(){
        int tam=asistentes.size();
        return tam;
    }
    public void añadeAs(Asistentes p){
        asistentes.add(p);
    }
    public void eliminarAsis(int pos){//añadir apartir de un jlist creo
        asistentes.remove(pos);
    }
    public int totalMayorEdad () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total += (asistente.getEdad() >= 18) ? 1 : 0;
        return total;
    }
    public int totalMenorEdad () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEdad() < 18) ? 1 : 0;
        return total;
    }
    public int totalHombres () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getSexo().equalsIgnoreCase("masculino")) ? 1 : 0;
        return total;
    }
    public int totalMujeres () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getSexo().equalsIgnoreCase("femenino")) ? 1 : 0;
        return total;
    }
    public int totalSolteros () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("soltero")) ? 1 : 0;
        return total;
    }
    public int totalCasados () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("casado")) ? 1 : 0;
        return total;
    }
    public int totalViudos () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("viudo")) ? 1 : 0;
        return total;
    }
    public int totalDivorciados () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("divorciado")) ? 1 : 0;
        return total;
    }
    public float porcentajeHombres () {
        float total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getSexo().equalsIgnoreCase("masculino")) ? 1 : 0;
        return (total/asistentes.size()) * 100;
    }
    public float porcentajeMujeres () {
        float total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getSexo().equalsIgnoreCase("femenino")) ? 1 : 0;
        return (total/asistentes.size()) * 100;
    }
    public String viewAll () {
        String info = "";
        for (Asistentes aux : asistentes)
            info += aux.toString() + "\n";
        String totales = "Total: " + totalAsistentes() + "\n"
                + "Mayores de Edad: " + totalMayorEdad() + "\n"
                + "Menores de Edad: " + totalMenorEdad() + "\n"
                + "Hombres: " + totalHombres() + "\n"
                + "Mujeres: " + totalMujeres() + "\n"
                + "Solteros: " + totalSolteros() + "\n"
                + "Casados: " + totalCasados() + "\n"
                + "Viudos: " + totalViudos() + "\n"
                + "Divorciados: " + totalDivorciados() + "\n"
                + "Porcentaje Hombres: " + porcentajeHombres() + "%\n"
                + "Porcentaje Mujeres: " + porcentajeMujeres() + "%";
        return info + "\n\n\n" + totales;
    }   
}
