
/* First solution */
def isPrime1(def num){
  if(num == 2) return true
    int limit = Math.sqrt(num) + 1 //limite
    (2..limit).each{ n ->
      if(num%n == 0){
        return false
      }
    }
    return true
}
def result1 = (2..20).findAll{ isPrime1(it)}
/*This isPrime1 cannot return the prime list*/


def isPrime2(def num){
  if(num == 2) return true
  int limit = Math.sqrt(num) + 1 //limite
  for( n in 2..limit){
    if(num%n == 0 ) return false
  }
  return true
}
def result2 = (2..20).findAll{ isPrime2(it)}
//println result2
/*Using the for statement, we can return the prime list*/

def isPrime3(def num){
  def limit = Math.sqrt(num) + 1
  // Remember !null == true
  def result = num == 2 || !(2..limit).find { num % it == 0 }
  println "Numero: ${num} Es primo? ${result}"
  result
}

def result3 = (2..20).findAll{ isPrime3(it) }
println result3
def resultOfTen = isPrime3(10)
println "10 es primo? ${resultOfTen}"

// MetaClass  isPrime()

Number.metaClass.isPrime = { ->
  Integer x = delegate as Integer
  Integer limit = Math.sqrt(x) + 1
  x == 2 || !(2..limit).find { x % it == 0 }
}

def result4 = (2..20).findAll{it.isPrime()}
println "Resultado de metaclass: ${result4}"

