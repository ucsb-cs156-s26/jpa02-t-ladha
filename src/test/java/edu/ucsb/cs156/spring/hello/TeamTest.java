package edu.ucsb.cs156.spring.hello;
//used documentation found here: https://docs.junit.org/5.7.0-RC1/user-guide/index.html#writing-tests-assertions
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse; //looked at documentation to add assertTrue when checking for equals in objects
import static org.junit.jupiter.api.Assertions.assertTrue; //same as above
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    //Case 1 of equals: same object 
    @Test
    public void testEqualsSameObject() {
        Team t = new Team("test-team");
        t.addMember("Tanvi");
        assertTrue(t.equals(t));
    }

    //Case 2 of equals: different class 
    @Test
    public void testEqualsDifferentClass() {
        Team t = new Team("test-team");
        assertFalse(t.equals("not a team"));
    }

    //Case 3 of equals: table of 4 possibilities in jpa02
    //only three test cases needed to test all 4 possibilities 
    @Test
    public void testEqualsSameNameSameMembers() {
        Team t1 = new Team("test-team-samename");
        t1.addMember("Tanvi");
        t1.addMember("Vanessa");

        Team t2 = new Team("test-team-samename");
        t2.addMember("Tanvi");
        t2.addMember("Vanessa");

        assertTrue(t1.equals(t2));
    }

    @Test
    public void testEqualsDifferentNameSameMembers() {
        Team t1 = new Team("test-team-differentname");
        t1.addMember("Tanvi");

        Team t2 = new Team("test-team-differentname2");
        t2.addMember("Tanvi");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void testEqualsSameNameDifferentMembers() {
        Team t1 = new Team("test-team-samename");
        t1.addMember("Tanvi");

        Team t2 = new Team("test-team-samename");
        t2.addMember("Vanessa");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void testHashCode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        //Team t2 = new Team();
        //t2.setName("foo");
        //t2.addMember("bar");
        //assertEquals(t1.hashCode(), t2.hashCode());
        int result = t1.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);
    }




}
