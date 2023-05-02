
import com.monlau.PRACTICA.clasesAbstractas.RevisionAlarma;
import com.monlau.PRACTICA.clasesAbstractas.Servicio;
import com.monlau.PRACTICA.clasesAbstractas.TrabajoPintura;
import java.time.LocalDate;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        ArrayList<Servicio> servicios = new ArrayList<>();

        // Trabajos de pintura
        TrabajoPintura trabajo1 = new TrabajoPintura("Dylan Pila", LocalDate.now(), "Toni Bone", 1100, 35);
        servicios.add(trabajo1);
        TrabajoPintura trabajo2 = new TrabajoPintura("Silvia Gimenez", LocalDate.of(2023, 2, 28), "Xavier Gimenez", 55, 45);
        servicios.add(trabajo2);

        // Revisiones de alarmas
        RevisionAlarma revision1 = new RevisionAlarma(LocalDate.now(), "Diego Sanchez", 10);
        servicios.add(revision1);
        RevisionAlarma revision2 = new RevisionAlarma(LocalDate.of(2023, 5, 25), "Laia Gimenez", 25);
        servicios.add(revision2);

        // Cálculo de la suma de los costes de todos los trabajos
        double costeTotal = 0.0;
        for (Servicio servicio : servicios) {
            costeTotal += servicio.costeTotal();
        }
        System.out.println("El coste total de todos los trabajos es: " + costeTotal);

        // Cálculo de lo que se tiene que pagar en total en sueldos por esos trabajos realizados
        double costeSueldos = 0.0;
        for (Servicio servicio : servicios) {
            if (servicio instanceof TrabajoPintura trabajoPintura) {
                costeSueldos += trabajoPintura.costeManoObra() * 0.25;
            } else {
                costeSueldos += servicio.costeManoObra() * 0.15;
            }
        }
        System.out.println("El coste total en sueldos es: " + costeSueldos);

        // Muestra en pantalla el resumen detallado de cada uno de esos trabajos
        for (Servicio servicio : servicios) {
            System.out.println(servicio.detalleServicio());
        }
    }
}