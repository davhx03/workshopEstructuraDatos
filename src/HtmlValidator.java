import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		Stack<HtmlTag> stackTags = new Stack<>();

		// Verificar si la cola que entra que entra esta vacia
		//vacio, return retorna vacia,
		//solo open    siempre dato ultimo   //cola siempre primero
		//1. verificamos que no sea una etiqueta de autocierre, y continuamos
		// isemty, mira si está vacía, isopentag las abiertas, de autocierre isselfclosing
		//matches que compara si es cerrado y abierto
		//Test 1: <u><b></b><i></i></u>
		//Test 2: <html><b> bold text <i> italic text </i>
		//Test 3: <b> <i> bold and italic </b> </i>
		//Test 4: <b> some text <i> </i> </b> </b> </html>

		if (tags.isEmpty()){
			return null;
		}
			//mientras la cola no este este vacia hacer
			for (HtmlTag currentTag : tags) {
				//2. crear la pila con las abiertas
				if (currentTag.isOpenTag()) {
					// Push open tags to the stack
					stackTags.push(currentTag);
					//si pilas vacias es porque el html esta bien
				}else if(!currentTag.isSelfClosing()){
					if(currentTag.matches(stackTags.peek())){
						stackTags.pop();
					}else{
						return stackTags;
					}
				}

		}
			return stackTags;


	//currentTag.matches(stackTags.peek()))
//				if (tags.poll().matches(stackTags.peek())) {
//					stackTags.pop();
//				} else {
//					return stackTags;  //eliminas
//				}
//			}


//		HtmlTag openTag = stack.peek();
//
//		if (currentTag.matches(openTag)) {
//			stack.pop();
//		} else {
//			return stack;
//		}

//		return null; // this line is here only so this code will compile if you don't modify it
	}
}
