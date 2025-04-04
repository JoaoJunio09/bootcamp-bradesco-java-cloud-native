package entities;

import java.util.Objects;

public class Cliente {
    
    private Integer id;
    private String nome;
    private Integer idade;
    private Double saldo;

    public Cliente() {}

    public Cliente(Integer id, String nome, Integer idade, Double saldo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double sacarDinheiro(Double valor) {
        this.saldo -= valor;
        return getSaldo();
    }

    public Double depositarDinheiro(Double valor) {
        this.saldo += valor;
        return getSaldo();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId()) && Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getIdade(), cliente.getIdade()) && Objects.equals(getSaldo(), cliente.getSaldo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIdade(), getSaldo());
    }
}
