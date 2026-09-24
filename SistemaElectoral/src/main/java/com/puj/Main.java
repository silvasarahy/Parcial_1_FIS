package com.puj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<RegistroAuditoria> bitacora = new ArrayList<>();
        Usuario admin = new Usuario("U1", "Admin General", "ADMINISTRADOR");

        // HU-01
        ProcesoElectoral proceso = new ProcesoElectoral("CON-2026", "Congreso", LocalDate.of(2026, 3, 8));
        proceso.cambiarEstado("PROGRAMADO");
        bitacora.add(new RegistroAuditoria(admin, "Registrar proceso " + proceso.getId()));

        // HU-02
        Departamento bogota = new Departamento("11", "Bogotá D.C.");
        Departamento antioquia = new Departamento("05", "Antioquia");
        Municipio munBogota = new Municipio("11001", "Bogotá D.C.", bogota);
        Municipio medellin = new Municipio("05001", "Medellín", antioquia);
        bogota.agregarMunicipio(munBogota);
        antioquia.agregarMunicipio(medellin);
        proceso.agregarDepartamento(bogota);
        proceso.agregarDepartamento(antioquia);

        // HU-03
        PuestoVotacion puesto1 = new PuestoVotacion("P-001", "Colegio Central", "Calle 40 # 7-20", munBogota);
        PuestoVotacion puesto2 = new PuestoVotacion("P-101", "Coliseo Norte", "Carrera 50 # 10-15", medellin);
        munBogota.agregarPuesto(puesto1);
        medellin.agregarPuesto(puesto2);

        // HU-04
        Mesa mesa1 = new Mesa(1, 300, puesto1);
        Mesa mesa2 = new Mesa(1, 350, puesto2);
        puesto1.agregarMesa(mesa1);
        puesto2.agregarMesa(mesa2);

        // HU-05 y HU-06
        OrganizacionPolitica partidoA = new OrganizacionPolitica("PA", "Partido A");
        OrganizacionPolitica partidoB = new OrganizacionPolitica("PB", "Partido B");
        partidoA.habilitar();
        partidoB.habilitar();
        Candidato ana = new Candidato("1001", "Ana Gómez", partidoA);
        Candidato luis = new Candidato("1002", "Luis Pérez", partidoB);
        ana.aceptar();
        luis.aceptar();

        // HU-07
        Jurado carlos = new Jurado("2001", "Carlos Ruiz", "carlos@correo.co");
        Jurado marta = new Jurado("2002", "Marta Díaz", "marta@correo.co");
        AsignacionJurado a1 = new AsignacionJurado(carlos, mesa1, "Presidente");
        AsignacionJurado a2 = new AsignacionJurado(marta, mesa2, "Presidente");
        System.out.println(a1);
        System.out.println(a2);

        // HU-08
        proceso.cambiarEstado("EN_JORNADA");
        mesa1.instalar();
        mesa2.instalar();

        // HU-11
        Incidente incidente = new Incidente("INC-1", "LOGISTICO", "Retraso en la entrega del material",
                LocalDateTime.of(2026, 3, 8, 8, 15), puesto1);
        incidente.asignarResponsable("Coordinador de puesto");
        incidente.resolver();
        System.out.println(incidente);

        mesa1.cerrar();
        mesa2.cerrar();

        // HU-09 y HU-10
        Acta acta1 = new Acta("ACTA-1", mesa1);
        acta1.registrarVotos(ana, 150);
        acta1.registrarVotos(luis, 120);
        acta1.setVotosBlanco(5);
        acta1.setVotosNulos(3);
        System.out.println("Alerta acta 1: " + acta1.verificarConsistencia());
        acta1.validar();
        acta1.cerrar();

        Acta acta2 = new Acta("ACTA-2", mesa2);
        acta2.registrarVotos(ana, 200);
        acta2.registrarVotos(luis, 160);
        Alerta alerta = acta2.verificarConsistencia();
        System.out.println("Alerta acta 2: " + alerta);
        acta2.validar();
        acta2.cerrar();

        // HU-12
        Reclamacion reclamacion = new Reclamacion("REC-1", "Testigo Paula Mora", LocalDate.of(2026, 3, 8),
                "El total supera el censo de la mesa", acta2);
        reclamacion.iniciarRevision();
        reclamacion.resolver("Se revisa el conteo y se confirma el error");
        alerta.resolver();
        System.out.println(reclamacion);

        // HU-13
        Consolidacion consolidacion = new Consolidacion(proceso);
        consolidacion.agregarActa(acta1);
        consolidacion.agregarActa(acta2);
        consolidacion.validar();
        consolidacion.publicar();
        System.out.println(consolidacion);

        // HU-14
        System.out.println("Total Ana Gómez: " + consolidacion.totalVotosCandidato(ana));
        System.out.println("Total Luis Pérez: " + consolidacion.totalVotosCandidato(luis));
        System.out.println("Ana en Bogotá D.C.: " + consolidacion.votosPorDepartamento(ana, bogota));
        System.out.println("Ana en Antioquia: " + consolidacion.votosPorDepartamento(ana, antioquia));

        // HU-15
        bitacora.add(new RegistroAuditoria(admin, "Publicar consolidación"));
        System.out.println("¿Admin es administrador? " + admin.tieneRol("ADMINISTRADOR"));
        for (RegistroAuditoria r : bitacora) {
            System.out.println(r);
        }
    }
}
