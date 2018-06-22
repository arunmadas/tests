

import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@DisplayName("Test Suite for Ericson Codility Problems")
@RunWith(JUnitPlatform.class)
@SelectPackages({"subdecimal","coin", "gasfilling"})
public class EricsonTestSuite {

}
