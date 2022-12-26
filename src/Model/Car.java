package Model;

import java.util.Objects;

public class Car {

    private State state;
    private String number;
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public String generateNumber(){
        int l = 5;
        String character = "1234567890QWERTYUIOOPASDFGHJKLZXCVBNM";
        StringBuilder s = new StringBuilder(l);
        for (int i = 0; i < l; i++) {
            int ch = (int)(character.length()*Math.random());
            s.append(character.charAt(ch));
        }
        String number = this.number;
        setNumber(s.toString());

        return number;

    }
    public  State changeStatus(Car car){
        java.util.Random r = new java.util.Random();
        int chance = r.nextInt(100)+1;
        State state = this.state;
        if (chance <= 3 && car.getState().equals(State.ON_RIDE)){
            setState(State.IN_PARK);
        } else if (chance<=3 && car.getState().equals(State.IN_PARK)) {
            setState(State.ON_RIDE);

        }
        return state;
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
    public String toString() {
        return "Car{" +
                "state=" + state +
                ", number='" + number + '\'' +
                ", time=" + time +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return time == car.time && price == car.price && state == car.state && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, number, time, price);
    }
}
