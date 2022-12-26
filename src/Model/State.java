package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public enum State {
    IN_PARK("In Park"){
        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public LocalDateTime saveTime(Car car,LocalDateTime ld) {
            changeStatus(car);
            if (car.getState().equals(IN_PARK)){
                car.setLd(ld);
                return ld;

            }
            return ld;
        }

        @Override
        public State changeStatus(Car car) {
            java.util.Random r = new java.util.Random();
            int chance = r.nextInt(100) + 1;
            State state=car.getState();
            if (chance==3){
                car.setState(State.ON_RIDE);
            }
            return state;
        }
    },
    ON_RIDE("On Ride"){
        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public LocalDateTime saveTime(Car car,LocalDateTime ld) {
            changeStatus(car);

           if (car.getState().equals(IN_PARK)){
               car.setLd(ld);
               return ld;
           }
           return ld;
        }

        @Override
        public State changeStatus(Car car) {
            java.util.Random r = new java.util.Random();
            int chance = r.nextInt(100) + 1;
            State state=car.getState();
            if (chance==3){
                car.setState(State.IN_PARK);
            }
            return state;
        }
    };
    private String value;

    public String getValue() {
        return value;
    }

    State(String value) {
        this.value = value;
    }

    public abstract LocalDateTime saveTime(Car car,LocalDateTime ld);
    public abstract State changeStatus(Car car);
}
