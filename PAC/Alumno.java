package PAC;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Alumno implements Serializable {
    private Long id;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String sexo;
    private Set <Modulo> Modulos= new HashSet<Modulo>(0);

    public Alumno (){
    }
    public Alumno(Long id, String nombre, String nacionalidad, int edad, String sexo, Set <Modulo> Modulos){
        this.id=id;
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.edad=edad;
        this.sexo=sexo;
        this.Modulos=Modulos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Set<Modulo> getModulos() {
        return Modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        Modulos = modulos;
    }

    public void addModulo (Modulo modulo) {
        this.Modulos.add (modulo);
    }
    @Override
    public String toString() {
        return "Insert into alumno, nombre: '" +
                nombre + '\'' +
                ", nacionalidad: '" + nacionalidad + '\'' +
                ", edad:" + edad +
                ", sexo:'" + sexo + '\'' +
                ", modulos: " + Modulos.size() ;
    }


}

