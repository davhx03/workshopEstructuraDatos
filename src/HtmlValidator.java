import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stackTags = new Stack<>();

		// Verify the Queue is not Empty
		if (tags.isEmpty()){
			return null;
		}
			for (HtmlTag currentTag : tags) {
				if (currentTag.isOpenTag()) {
					// Push open tags to the stack
					stackTags.push(currentTag);
					//Goes to the non Open Tags
				}else if(!currentTag.isSelfClosing()){ // But skipping the SelfClosing Tags
					//If the Stack is not empty and the current Tag matches the Stack Top
					//Then the top will be Removes
					if(!stackTags.isEmpty() && currentTag.matches(stackTags.peek())){
						stackTags.pop();
					} else if (stackTags.isEmpty()) { //If the Stack is Empty, means there are not enough OpenTags and the loop is not Finished
						return null;
					} else{ //A wrong closing Tag was found, so the current Stack will be returned
						return stackTags;
					}
				}
		}
			//If the HTML is right, an Empty Stack will be returned
			return stackTags;
	}
}
