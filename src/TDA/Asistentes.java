package TDA;
public class Asistentes {

    public Asistentes () {
        
    }

    public Asistentes(String nombre, byte edad, String sexo, String estadoCivil) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }
    
    private String nombre;
    private byte edad;
    private String sexo; // Masculino   Femenino
    private String estadoCivil; // Soltero  Casado  Viudo   Divorciado

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }
    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Asistentes{" + "nombre=" + nombre + ", "
                + "edad=" + edad + ", sexo=" + sexo + ","
                + " estadoCivil=" + estadoCivil + '}';
    }
    
}
