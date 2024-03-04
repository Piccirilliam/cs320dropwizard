package com.dropwizard.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppointmentService {
    private List<Appointment> appointments;
    private Set<String> appointmentIds;

    public AppointmentService() {
        appointments = new ArrayList<>();
        appointmentIds = new HashSet<>();
    }

    public void addAppointment(Appointment appointment) {
        String appointmentId = appointment.getAppointmentId();
        if (!appointmentIds.add(appointmentId)) { // Returns false if this ID already exists
            throw new IllegalArgumentException("Duplicate appointment Id: " + appointmentId);
        }
        appointments.add(appointment);
    }

    public void deleteAppointment(String Id) {
        if (!appointmentIds.remove(Id)) { // Returns false if the ID did not exist
            throw new IllegalArgumentException("Appointment Id not found: " + Id);
        }
        appointments.removeIf(appointment -> appointment.getAppointmentId().equals(Id));
    }
}
