package model;
// Generated 07/03/2016 05:45:46 PM by Hibernate Tools 4.3.1



/**
 * Distritos generated by hbm2java
 */
public class Distritos  implements java.io.Serializable {


     private Integer iddistrito;
     private Provincias provincias;
     private String distrito;

    public Distritos() {
    }

    public Distritos(Provincias provincias, String distrito) {
       this.provincias = provincias;
       this.distrito = distrito;
    }
   
    public Integer getIddistrito() {
        return this.iddistrito;
    }
    
    public void setIddistrito(Integer iddistrito) {
        this.iddistrito = iddistrito;
    }
    public Provincias getProvincias() {
        return this.provincias;
    }
    
    public void setProvincias(Provincias provincias) {
        this.provincias = provincias;
    }
    public String getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }




}

