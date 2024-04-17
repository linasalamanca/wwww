package com.example.PrimeraEntregaWeb.dto;

public class InformacionCompraProductoDTO {
    private String nombreProducto;
    private Double cantidad;
    private Double precio;
    private Double oferta;

    public InformacionCompraProductoDTO(String nombreProducto, Double cantidad, Double oferta, Double precio) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.oferta = oferta;
        this.precio = precio;
    }

    public InformacionCompraProductoDTO() {
    }

    public Double getOferta() {
        return oferta;
    }

    public void setOferta(Double oferta) {
        this.oferta = oferta;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
