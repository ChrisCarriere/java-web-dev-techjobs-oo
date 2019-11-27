package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job;
    Job test_job2;
    Job testJob3;
    Job testJob4;

    @Before
    public void createJobObject() {
        test_job = new Job();
        test_job2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }


    @Test
    public void testSettingJobId() {
        assertFalse(test_job.getId() == test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJob3 instanceof Job);
        assertTrue(testJob3.getName() instanceof String);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
       assertFalse(testJob3.equals(testJob4));
    }

    @Test
    public void testJobToString(){
        String[] arr = testJob3.toString().split("");
        assertTrue(testJob3.toString().contains("\n"));
        assertEquals("\n", arr[0]);
        assertEquals("\n", arr[arr.length-1]);
    }

    @Test
    public void testEmptyJobFieldToString(){
        Job testJob = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" +
                "ID: 17\n" +
                "Name: Data not available\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position: Quality control\n" +
                "Core Competencies: Persistence" +
                "\n", testJob.toString());
    }

    @Test
    public void testCompleteJobToString(){
        assertEquals("\n" +
                "ID: 11\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position: Quality control\n" +
                "Core Competencies: Persistence" +
                "\n", testJob3.toString());
    }
}
