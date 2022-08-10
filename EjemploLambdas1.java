/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplolambdas1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author elkin
 */
public class EjemploLambdas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> textos = new ArrayList<>();
        textos.add("zzzzzzzzzzzzzzz gfg");
        textos.add("ddddddddb sth");
        textos.add("ttt");
        for (String s : textos) {
            System.out.println("--->" + s);
        }
        textos.sort((a, b) -> a.length() - b.length());

        for (String texto : textos) {
            System.out.println("ok--->" + texto);
        }

        //apartir de una colecion 
        Stream<String> st = textos.stream();
        st.forEach(s -> System.out.println("st->" + s));

        //APERTIR DE UN ARRAY
        String[] cads = new String[]{"unod", "tres", "cuatro"};
        Stream<String> stcads = Arrays.stream(cads);
        stcads.map((a) -> a.toUpperCase()).forEach(s -> System.out.println("stcads->" + s));

        //apartir de una serie discreta
        Stream<Integer> stdouble = Stream.of(4, 1, 6, 3);
        stdouble.sorted((a, b) -> a - b).forEach(s -> System.out.println("stdouble->" + s));

        Stream<Integer> stfilter = Stream.of(4, 1, 6, 3);
        stfilter.filter(s -> s % 2 == 0).forEach(s -> System.out.println("stfilter->" + s));
        //stfilter.filter(s->s%2==0).forEach(s -> System.out.println("stfilter->" + s));

        Stream<Integer> st1 = Stream.of(2, 3, 2, 8, 1, 0, 6);
        System.out.println("333333333333333333333333333333");
        List<Integer> listnums = st1.distinct().collect(Collectors.toList());
        for (Integer listnum : listnums) {
            System.out.println(listnum);
        }
        //System.out.println(st1.peek(a->System.out.println(a)).filter(s->s%2==0).count());
        //st1.peek(a->System.out.println(a)).count();

        Stream<Integer> st11 = Stream.of(2, 3, 2, 8, 1, 0, 6);
        Optional<Integer> opInt = st11.filter(s -> s % 2 == 0).findFirst();
        System.out.println(opInt.get());

        Stream<Integer> st12 = Stream.of(2, 3, 2, 8, 1, 0, 6);
        //Integer[] arrayUnt= st12.toArray(new );
        Integer[] arrayUnt = st12.toArray(s -> new Integer[s]);
        for (int i = 0; i < arrayUnt.length; i++) {
            System.out.println("***->" + arrayUnt[i]);

        }

        List<List<String>> datos = Arrays.asList(
                Arrays.asList("elkin", "Juan", "Carlos"),
                Arrays.asList("Pedro", "Pablo", "pepe")
        );
        System.out.println(datos
                .stream()
                .flatMap(l -> l.stream().map(s -> s.length()))
                .filter(a -> a > 4)
                .count());
        Integer[][] datosrray = {{8, 3, 5}, {9, 5, 6}, {1, 2, 3,71}};
        System.out.println(Arrays.stream(datosrray)
                .flatMap(l -> Arrays.stream(l))
                .mapToInt(m -> m)
                .max()
                .getAsInt());
        
        Stream<Integer> nums=Stream.of(2,1,6,4,8);
        System.out.println("total:"+nums
                .filter(n->n%2==0)
                .peek(n->System.out.println("Par:"+n))
                .count());
        
        Stream<Integer> nums1=Stream.of(20, 6,8,3,9);
        nums1.peek(n->System.out.println(n)).allMatch(n->n>5);
        
        Stream<Persona> stP= Stream.of(new Persona("Elkin",40),
                new Persona("flaca",12),new Persona("mao",25));
        stP.sorted(Comparator.comparing(p->p.getEdad())).forEach(p->System.out.println(p.getNombre()));

        String[] lines = new String[]{"line 1", "line 2", "line 2"};
        Path archivo = Paths.get("C:\\Curso\\puebaFichero.txt");
        try {
            Stream<String> stream = Files.lines(archivo);
            stream.forEach(c -> System.out.println("path->" + c));
            BufferedWriter br = Files.newBufferedWriter(archivo,
                    Charset.defaultCharset(), StandardOpenOption.CREATE);

            Arrays.stream(lines).forEach((s) -> {
                try {
                    br.write(s);
                    br.newLine();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }

            });
        } catch (IOException ex) {
            Logger.getLogger(EjemploLambdas1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
