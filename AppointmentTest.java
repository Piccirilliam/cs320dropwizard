package com.dropwizard.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    private Appointment appointment;
    private Date futureDate;

    @BeforeEach
    void setUp() {
        futureDate = new Date(System.currentTimeMillis() + 10000); // Ensures date is in the future
        appointment = new Appointment("12345", futureDate, "Teeth Cleaning");
    }

    @Test
    void testAppointmentValuesCorrect() {
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals("Teeth Cleaning", appointment.getApptDescription());
        assertEquals(futureDate, appointment.getAppointmentDate());
    }

    @Test
    void testAppointmentObjectNotNull() {
        assertNotNull(appointment);
    }

    @Test
    void testSettingAppointmentDateInPastThrowsException() {
        Date pastDate = new Date(System.currentTimeMillis() - 10000);
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastDate));
    }

    @Test
    void testSettingInvalidDescriptionsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> appointment.setApptDescription(null));
        assertThrows(IllegalArgumentException.class, () -> appointment.setApptDescription("This description intentionally exceeds the fifty-character limit to trigger validation."));
    }
}
