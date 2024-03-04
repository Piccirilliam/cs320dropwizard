package com.dropwizard.classes;

import java.util.Date;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private String apptDescription;

    public Appointment(String appointmentId, Date appointmentDate, String apptDescription) {
        this.appointmentId = validateApptId(appointmentId);
        this.appointmentDate = validateDate(appointmentDate);
        this.apptDescription = validateDetails(apptDescription);
    }

    private String validateApptId(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Appointment ID is invalid or too long");
        }
        return id;
    }

    private Date validateDate(Date date) {
        if (date.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
        return date;
    }

    private String validateDetails(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Appointment description is invalid or too lengthy");
        }
        return description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date date) {
        this.appointmentDate = validateDate(date);
    }

    public String getApptDescription() {
        return apptDescription;
    }

    public void setApptDescription(String details) {
        this.apptDescription = validateDetails(details);
    }
}
