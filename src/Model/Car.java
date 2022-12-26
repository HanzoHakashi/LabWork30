package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Car {

    private State state;
    private String number;
    LocalDateTime ld;

    public LocalDateTime getLd() {
        return ld;
    }

    public void setLd(LocalDateTime ld) {
        this.ld = ld;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String generateNumber() {
        int l = 5;
        String character = "1234567890QWERTYUIOOPASDFGHJKLZXCVBNM";
        StringBuilder s = new StringBuilder(l);
        for (int i = 0; i < l; i++) {
            int ch = (int) (character.length() * Math.random());
            s.append(character.charAt(ch));
        }
        String number = this.number;
        setNumber(s.toString());

        return number;

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && state == car.state && Objects.equals(number, car.number) && Objects.equals(ld, car.ld);
    }

    @Override
    public String toString() {
        return "Car{" +
                "state=" + state +
                ", number='" + number + '\'' +
                ", ld=" + ld +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, number, ld, price);
    }
}
