package ar.com.undec.escuela.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Curso {
    private Integer id;
    private String nombre;
    private Collection<Clase> clasesById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(nombre, curso.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @OneToMany(mappedBy = "cursoByIdCurso")
    public Collection<Clase> getClasesById() {
        return clasesById;
    }

    public void setClasesById(Collection<Clase> clasesById) {
        this.clasesById = clasesById;
    }
}
