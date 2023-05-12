
/**
 *
 * @author Pedro G Gallardo
 */
public class Aparcamiento {

    private int PARCodigo, PARplazasRotacion, PARplazasResidente, PARplazasDisuasorias;
    private String PARNombrePar, PARtipo, PARdistrito;

    public Aparcamiento(String PARCodigo, String PARNombrePar, String PARtipo, String PARplazasRotacion, String PARplazasResidente, String PARplazasDisuasorias,
            String PARdistrito) {
        //Integer.parseInt(contenido[0])
        this.PARCodigo = Integer.parseInt(PARCodigo);
        if (PARplazasRotacion.equals("")) {
            this.PARplazasRotacion = 0;
        } else {
            this.PARplazasRotacion = Integer.parseInt(PARplazasRotacion);
        }
        if (PARplazasResidente.equals("")) {
            this.PARplazasResidente = 0;
        } else {
            this.PARplazasResidente = Integer.parseInt(PARplazasResidente);
        }
        if (PARplazasDisuasorias.equals("")) {
            this.PARplazasDisuasorias = 0;
        } else {
            this.PARplazasDisuasorias = Integer.parseInt(PARplazasDisuasorias);
        }
        this.PARNombrePar = PARNombrePar;
        this.PARtipo = PARtipo;
        this.PARdistrito = PARdistrito;
    }

    public int devuelvePlazas() throws Exception {
        switch (PARtipo) {
            case "ROTACION":
                return PARplazasRotacion;
            case "MIXTO":
                return PARplazasRotacion + PARplazasResidente;
            case "RESIDENTES":
                return PARplazasResidente;
            case "DISUASORIO":
                return PARplazasDisuasorias;
            default:
                throw new Exception("Error imprevisto, el tipo de aparcamiento no coincide con lo esperado");
        }
    }

    public int getPARCodigo() {
        return PARCodigo;
    }

    public int getPARplazasRotacion() {
        return PARplazasRotacion;
    }

    public int getPARplazasResidente() {
        return PARplazasResidente;
    }

    public int getPARplazasDisuasorias() {
        return PARplazasDisuasorias;
    }

    public String getPARNombrePar() {
        return PARNombrePar;
    }

    public String getPARtipo() {
        return PARtipo;
    }

    public String getPARdistrito() {
        return PARdistrito;
    }

}
