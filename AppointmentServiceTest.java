package com.dropwizard.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Appointment validAppointment;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        validAppointment = new Appointment("12345", futureDate, "Teeth Cleaning");
    }

    @Test
    void testAddingValidAppointmentDoesNotThrowException() {
        assertDoesNotThrow(() -> appointmentService.addAppointment(validAppointment));
    }

    @Test
    void testAddingDuplicateAppointmentThrowsException() {
        appointmentService.addAppointment(validAppointment);
        Appointment duplicateAppointment = new Appointment("12345", new Date(System.currentTimeMillis() + 10000), "Teeth Cleaning");

        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(duplicateAppointment));
    }

    @Test
    void testDeletingExistingAppointmentThenFailsToDeleteAgain() {
        appointmentService.addAppointment(validAppointment);
        appointmentService.deleteAppointment("12345");

        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("12345"));
    }

    @Test
    void testDeletingNonexistentAppointmentThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("NonExistentID"));
    }
}
