import collection.mutable.Stack
import org.scalatest._

class ExampleSpec extends WordSpec with Matchers {
  "A regex evaluator" should {
    "match these basic regexes" in {
      Regex.fullMatch("ab", "ab") should be(true)
      Regex.fullMatch("abbbbb", "ab+") should be(true)
      Regex.fullMatch("bbbbb", "ab+") should be(false)

      Regex.fullMatch("aaabbb", "a+b+") should be(true)
      Regex.fullMatch("ababa", "a+b+") should be(false)
      
      Regex.fullMatch("aaa", "a*") should be(true)
      Regex.fullMatch("", "a*") should be(true) 
    }

    "match the . character properly" in {
        full("a", ".") should be (true)
        full("ab", ".") should be(false)
        full("abab", "(..)*") should be(true)
        full("aba", "(..)*") should be (false)
    }

    "match more complex regexes" in {
      Regex.fullMatch("a", "(a*)*") should be (true)
      Regex.fullMatch("b", "(a*)*") should be (false)    
    }

    def full(input: String, pattern: String) = Regex.fullMatch(input, pattern)
  }
}