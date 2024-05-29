import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {


		// Verificar si la cola que entra que entra esta vacia
		//vacio, return retorna vacia,
		//solo open    siempre dato ultimo   //cola siempre primero
		//1. verificamos que no sea una etiqueta de autocierre, y continuamos
		// isemty, mira si está vacía, isopentag las abiertas, de autocierre isselfclosing
		//matches que compara si es cerrado y abierto


		Stack<HtmlTag> stackTags = new Stack<>();

		//mientras la cola no este este vacia hacer
		for (HtmlTag currentTag : tags) {

			//2. crear la pila con las abiertas
			if (currentTag.isOpenTag()) {
				// Push open tags to the stack
				stackTags.push(currentTag);
				tags.poll();
			}//si pilas vacias es porque el html esta bien
		}


		//currentTag.matches(stackTags.peek()))
		if(tags.poll().matches(stackTags.peek())){
			stackTags.pop();
			return stackTags;
		} else {
			return stackTags;//eliminas
		}


//		HtmlTag openTag = stack.peek();
//
//		if (currentTag.matches(openTag)) {
//			stack.pop();
//		} else {
//			return stack;
//		}

		if (stackTags.isEmpty()){
			return null;
		}

		return null; // this line is here only so this code will compile if you don't modify it
	}
}
