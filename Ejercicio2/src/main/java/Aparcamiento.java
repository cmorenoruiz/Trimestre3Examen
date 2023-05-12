
/**
 *
 * @author Pedro G Gallardo
 */
public class Aparcamiento {

    private int PARCodigo, PARplazasRotacion, PARplazasResidente, PARplazasDisuasorias;
    private String PARNombrePar, PARtipo, PARdistrito;

    public Aparcamiento(int PARCodigo, String PARNombrePar, String PARtipo, int PARplazasRotacion, int PARplazasResidente, int PARplazasDisuasorias, String PARdistrito) {
        this.PARCodigo = PARCodigo;
        this.PARplazasRotacion = PARplazasRotacion;
        this.PARplazasResidente = PARplazasResidente;
        this.PARplazasDisuasorias = PARplazasDisuasorias;
        this.PARNombrePar = PARNombrePar;
        this.PARtipo = PARtipo;
        this.PARdistrito = PARdistrito;
    }
}
