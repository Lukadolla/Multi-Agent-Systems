/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class Ping extends ASTRAClass {
	public Ping() {
		setParents(new Class[] {PingPong.class});
		addRule(new Rule(
			"Ping", new int[] {2,7,2,49},
			new MessageEvent(
				new Performative("request"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("ping", new Term[] {})
			),
			Predicate.TRUE,
			new Block(
				"Ping", new int[] {2,48,6,3},
				new Statement[] {
					new ModuleCall("console",
						"Ping", new int[] {3,4,3,27},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("ping")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Ping","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Ping", new int[] {4,4,4,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(500)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Ping","system")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Send("Ping", new int[] {5,4,5,32},
						new Performative("inform"),
						new Variable(Type.STRING, "sender"),
						new Predicate("pong", new Term[] {})
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Ping().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
