
class GroovyUtilityMethodsSpec extends GroovyTestCase{

  UtilityMethods impl

  void setUp(){
    println "Setup: Impl getting behaviour"
    impl = [
            getPositives: { values -> values.findAll{it>0}  },
            isPalindrome: { String s ->
                           String str = s.toLowerCase().replaceAll(/\W/,'')
                           str.reverse() == str
                         }
           ] as UtilityMethods
           //This is for cast map to UtilityMethods Impl
  }

  void testOne(){
    //Given
    def list = [-1, -2, 3, 6, 8]
    //When
    def results = impl.getPositives(list)
    //Then
    assert results == [3,6,8]
  }
}

interface UtilityMethods{
  def getPositives(def values)
  boolean isPalindrome(String s)
}

class GroovyUtilityMethods implements UtilityMethods{

  def getPositives(def values){
    values.findAll{it>0}
  }

  boolean isPalindrome(String s){
    String str = s.toLowerCase().replaceAll(/\W/,'')
    str.reverse() == str
  }

}


