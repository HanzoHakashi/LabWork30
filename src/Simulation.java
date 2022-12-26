import Model.Car;
import Model.State;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Simulation {
    public void park(){
        Car car=new Car();
        Set<Car>city = getCity();
        Set<Car>park= new HashSet<>(20);
        Set<Car>journal=new HashSet<>();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(30);
        LocalDateTime end2=LocalDateTime.now().plusMinutes(5);
        LocalDateTime end3=LocalDateTime.now().plusMinutes(30);
        String AM = "09:00:00";
        int time=1;

        for (LocalDateTime date = start;date.isBefore(end);date=date.plusDays(1)) {
            for (LocalDateTime j = start;j.isBefore(end2)  ; j=j.plusMinutes(1)) {
                for (var str:city) {
                    str.setLd(State.ON_RIDE.saveTime(str,j));
                    park.removeIf(e->str.getState().equals(State.ON_RIDE));
                    if (str.getState().equals(State.IN_PARK)&&park.size()<20){
                        str.setLd(str.getLd().plusMinutes(time++));
                        park.add(str);
                    } else if (j.isBefore(j.plusMinutes(30)) && j.getHour()>9 && j.getHour()<21 ) {
                        str.setPrice(time*2);
                    }
                    journal.add(str);
                }

            }
        }
        System.out.println(park.size());
        System.out.println(park.toString());
        System.out.println(journal.toString());
        System.out.println(journal.size());
    }

    public Set<Car> getCity(){
        Set<Car>city = new HashSet<>();
        for (int i = 0; i < 200; i++) {
            Car car = new Car();
            car.generateNumber();
            car.setState(State.ON_RIDE);
            city.add(car);
        }
        return city;
    }
}
