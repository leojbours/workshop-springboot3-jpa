package com.learningspring.course.entities;

public enum OrderStatus {
  WAITING_PAYMENT("Aguardando pagamento"),
  PAID("Pago"),
  SHIPPED("Enviado"),
  DELIVERED("Entregue"),
  CANCELLED("Cancelado");

  private final String label;

  OrderStatus(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return this.label;
  }

  public static OrderStatus fromString(String label) {
    for (OrderStatus value : OrderStatus.values()) {
      if (value.toString().equals(label)) {
        return value;
      }
    }
    throw new IllegalArgumentException("Not supported order status: " + label);
  }
}
