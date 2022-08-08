package com.nttdata.terpel.msprogramacion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetDespachoDto {
    @JsonProperty(value = "a03NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @JsonProperty(value = "a03COMPANIA")
    private String compania;
    @JsonProperty(value = "a03NUMERO_COMPARTIMENTO")
    private String numeroCompartimento;
    @JsonProperty(value = "a03CODIGO_MATERIAL")
    private String codigoMaterial;
    @JsonProperty(value = "a03VOLUMEN_PROGRAMADO")
    private double volumenProgramado;
    @JsonProperty(value = "a03VOLUMEN_DESPACHADO")
    private double volumenDespacho;
    @JsonProperty(value = "a03VOLUMEN_DESPACHADO_AJUSTADO")
    private double volumenDespachoAjustado;
    @JsonProperty(value = "a03TEMPERATURA_PROMEDIO_DESPACHO")
    private double tempPromedioDespacho;
    @JsonProperty(value = "a03VOLUMEN_DESPACHADO_STANDAR")
    private double volumenDespachoStandar;
    @JsonProperty(value = "a03DENSIDAD_API")
    private double densidadApi;
    @JsonProperty(value = "a03BRAZO")
    private String brazo;
    @JsonProperty(value = "a03ALMACEN")
    private String almacen;
    @JsonProperty(value = "a03ESTADO")
    private String estado;
    @JsonProperty(value = "a03CODIGO_NOVEDAD")
    private String codigoNovedad;
    @JsonProperty(value = "a03FECHAS_DESPACHO")
    private String fechaDespacho;
    @JsonProperty(value = "a03HORA_DESPACHO")
    private String horaDespacho;
    //@NotEmpty
    @JsonProperty(value = "a03IDPLANTA")
    private String idPlanta;
    @JsonProperty(value = "Flag_Rep")
    private int flagRep;
    @JsonProperty(value = "rowguid")
    private String rowGuid;
    @JsonProperty(value = "a03PRUEBA_CALIDAD")
    private int pruebaCalidad;
    @JsonProperty(value = "a03MFACTOR")
    private double mFactor;
}
