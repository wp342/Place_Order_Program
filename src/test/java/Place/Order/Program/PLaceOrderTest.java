package Place.Order.Program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PLaceOrderTest {
    @Test
    void CheckorderNumberValidation(){
        String orderNumber = "";
        String testString = "Dave Dumont,27 Towerbridge Rd, Portsmouth,Hants,PO1 734,Dave Dumont@Company.co.uk,078776 4598";
        Deliver_To deliverTo = TechAssessment.getAndSetDeliveryInformation(testString);
        Assertions.assertEquals("Invalid orderNumber", TechAssessment.DeliverToValidation(orderNumber, deliverTo));
        orderNumber = "ThisisBiggerthenfourteencharacters";
        Assertions.assertEquals("Invalid orderNumber", TechAssessment.DeliverToValidation(orderNumber, deliverTo));
        orderNumber = "MM001";
        assertNull(TechAssessment.DeliverToValidation(orderNumber, deliverTo));
    }

    @Test
    void CheckNameValidation(){
        String orderNumber = "MM001";
        String testString = "Dave Dumont,27 Towerbridge Rd, Portsmouth,Hants,PO1 734,malcolm.duke@Company.co.uk,078776 4598";
        Deliver_To deliverTo = TechAssessment.getAndSetDeliveryInformation(testString);
        assertNull(TechAssessment.DeliverToValidation(orderNumber, deliverTo));
        testString = "Dav,27 Towerbridge Rd, Portsmouth,Hants,PO1 734,malcolm.duke@Company.co.uk,078776 4598";
        deliverTo = TechAssessment.getAndSetDeliveryInformation(testString);
        Assertions.assertEquals("Invalid Name", TechAssessment.DeliverToValidation(orderNumber, deliverTo));
        testString = "Daaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvve Dumont,27 Towerbridge Rd, " +
                "Portsmouth,Hants,PO1 734,Daaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvve.Dumont@Company.co.uk,078776 4598";
        deliverTo = TechAssessment.getAndSetDeliveryInformation(testString);
        Assertions.assertEquals("Invalid Name", TechAssessment.DeliverToValidation(orderNumber, deliverTo));
    }

}