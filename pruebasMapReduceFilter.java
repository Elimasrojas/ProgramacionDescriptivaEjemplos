package mintic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class pruebasMapReduceFilter {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        Integer numeroInt = Arrays.stream(numeros).reduce(0, (x, y) -> x + y);
        System.out.println(numeroInt);

        Stream<Integer> str1=Stream.of(1,2,3,4,5);
        Stream<Integer> map = str1.map(x->x+1);
        map.forEach(x->System.out.print(x));
        System.out.println("***********");
        Stream<Integer> str2=Stream.of(1,2,3,4,5);
        System.out.println( str2.peek(a->System.out.println(a)).count());
        System.out.println("***********");
        Stream<Integer> str3=Stream.of(1,2,3,4,5);
        OptionalDouble is=str3.mapToInt(x->x).average();
        System.out.println(is.getAsDouble());
        System.out.println("***********");
        Stream<Integer> str4=Stream.of(1,2,3,4,5);
        Optional<Integer> maxOpt = str4.max((a,b)->a-b);
        System.out.println(maxOpt.get());
        System.out.println("***********");
        Stream<Integer> str5=Stream.of(1,2,3,4,5);
        List<Integer> lista = str5.distinct().collect(Collectors.toList()); 
        System.out.println(lista);
         System.out.println("***********");
        Stream<Integer> str6=Stream.of(1,8,0,4,-5);
        //str6.distinct().collect(Collectors.toMap(x->x,y->y)); 
        System.out.println(str6.distinct().collect(Collectors.toMap(x->x,y->y)));
        System.out.println("***********");
        int[] datos= new int[]{1,23,9};
        int envio=5;
        int descuento=switch (envio) {
            case 1,2,3->{
                System.out.println("1,2,3");
                int op=envio*3;
                yield op;
            }
            case 4,5,6->{
                System.out.println("4,5,6");
                int op=3;
                yield op;
            }    
            default->5;
        };
        System.out.println(descuento);
        
        String json="""
                    {
                    "nombre":"pepito",
                    "telefonos":[1111,2222]
                    }
                    """;
        System.out.println(json);
        Persona per= new Persona("elkin", "elias@gmail.com", 46);
        System.out.println(per.edad());
        


    }
    public record Persona(String nombre,String email,int edad){
        
    }

}
