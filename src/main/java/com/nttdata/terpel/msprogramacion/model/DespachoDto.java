package com.nttdata.terpel.msprogramacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class DespachoDto implements Serializable {
    private static final long serialVersionUID = 586144036199278530L;
    //@NotEmpty
    @JsonProperty(value = "a02IDPLANTA")
    private String idPlanta;
    @JsonProperty(value = "a02NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @JsonProperty(value = "a02COMPANIA")
    private String compania;
    @JsonProperty(value = "a02ESTADO")
    private int estado;
    @JsonProperty(value = "a02PLACA")
    private  String placa;
    @JsonProperty(value = "a02FECHA_DOCUMENTO")
    private String fechaDocumento;
    @JsonProperty(value = "a02HORA_DOCUMENTO")
    private String horaDocumento;
    @JsonProperty(value = "a02NUMERO_COMPARTIMENTO")
    private int numeroCompartimento;
    @JsonProperty(value = "a02TIPO_MOVIMIENTO")
    private String tipoMovimiento;
    @JsonProperty(value = "a02PIN")
    private int pin;
    @JsonProperty(value = "a02SOPORTE_MOVIMIENTO")
    private String soporteMovimiento;
    @JsonProperty(value = "a02ORIGEN_DOCUMENTO")
    private String origenMovimiento;
    @JsonProperty(value = "a02OBS")
    private String obs;
    @JsonProperty(value = "a02FECHA_SQL")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "GMT-5")
    private Date fechaSql;
    @JsonProperty(value = "Flag_Rep")
    private int flagRep;
    @JsonProperty(value = "rowguid")
    private String rowGuid;
    @JsonProperty(value = "a02IdentiConductor")
    private String idConductor;
    @JsonProperty(value = "a02NIT")
    private String nit;
    @JsonProperty(value = "a02CISTERNA")
    private String cisterna;
    @JsonProperty(value = "a02CAUSAL_ANULACION")
    private String causalAnulacion;
    @JsonProperty(value = "a02DESPACHOENVIADO")
    private int despachoEnviado;
}
