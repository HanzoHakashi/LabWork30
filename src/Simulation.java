import Model.Car;
import Model.State;

import java.util.HashSet;
import java.util.Set;

public class Simulation {
    public void park(){
        Car car=new Car();
        Set<Car>city = getCity();
        Set<Car>park= new HashSet<>(20);
        Set<Car>journal=new HashSet<>();
        System.out.println(city.toString());
        for (int i = 0; i < 30; i++) {
            for (int j = 1; j < 5; j++) {
                for (var str:city) {
                    str.changeStatus(str);
                    park.removeIf(e->e.getState().equals(State.ON_RIDE));
                    if(str.getState().equals(State.IN_PARK) && park.size()<20){
                        park.add(str);
                        str.setTime(j++);
                        str.setPrice((j++)*2);
                        journal.add(str);
                        if(str.getTime()>=30){
                            str.setPrice(str.getTime()*2);
                        }
                    }
                }
            }
        }
        System.out.println(park.toString());
        System.out.println(journal.toString());


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
