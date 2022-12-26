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
        int time=1;

        for (LocalDateTime date = start;date.isBefore(end);date=date.plusDays(1)) {
            for (LocalDateTime j = start;j.isBefore(LocalDateTime.now().plusMinutes(5))  ; j=j.plusMinutes(1)) {
                for (var str:city) {
                    str.setLd(State.ON_RIDE.saveTime(str,j));
                    journal.add(str);
                    park.removeIf(e->str.getState().equals(State.ON_RIDE));
                    if (str.getState().equals(State.IN_PARK)&&park.size()<20){
                        str.setLd(str.getLd().plusMinutes(time++));
                        park.add(str);
                    } else if (j.isBefore(j.plusMinutes(30)) && j.getHour()>9 && j.getHour()<21 ) {
                        str.setPrice(j.getMinute()*2);
                        int price= str.getPrice()+str.getPrice();
                    }

                }

            }
        }
        System.out.printf("На данный момент на парковке находится %s машин.%n",park.size());
        System.out.printf("В общем за этот месяц на парковку заехало и уехало %s машин.%n",journal.size());
        int price=0;
        for (var str:journal) {
            price+=str.getPrice();
        }
        System.out.printf("Общая прибыль составила %s.%n",price);
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
