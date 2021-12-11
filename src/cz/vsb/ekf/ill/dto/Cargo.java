package cz.vsb.ekf.ill.dto;

public class Cargo {

    private Integer id;
    private String description;
    private Integer weight;
    private Integer totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CARGO{"
                + "ID: " + id
                + ", description='" + description + '\''
                + ", weight= " + weight + "kg"
                + ", totalPrice= " + totalPrice + "USD"
                + '}';
    }

}
