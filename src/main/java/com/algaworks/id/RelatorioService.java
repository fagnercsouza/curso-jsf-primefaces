package com.algaworks.id;

import java.math.BigDecimal;

public class RelatorioService {

    private Pedidos pedidos;
    public BigDecimal totalPedidosMesAtual(){
        return pedidos.totalPedidosMesAtual();
    }
}
