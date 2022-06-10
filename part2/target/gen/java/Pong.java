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


public class Pong extends ASTRAClass {
	public Pong() {
		setParents(new Class[] {PingPong.class});
		addRule(new Rule(
			"Pong", new int[] {2,7,2,23},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "S",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Pong", new int[] {2,22,6,3},
				new Statement[] {
					new ForAll(
						"Pong", new int[] {3,4,3,24},
						new Variable(Type.STRING, "I",false),
						new Variable(Type.LIST, "S"),
						new Block(
							"Pong", new int[] {3,25,6,3},
							new Statement[] {
								new Send("Pong", new int[] {4,5,4,29},
									new Performative("request"),
									new Variable(Type.STRING, "I"),
									new Predicate("ping", new Term[] {})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Pong", new int[] {8,7,8,48},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("pong", new Term[] {})
			),
			Predicate.TRUE,
			new Block(
				"Pong", new int[] {8,47,12,3},
				new Statement[] {
					new ModuleCall("console",
						"Pong", new int[] {9,4,9,27},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("pong")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Pong","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Pong", new int[] {10,4,10,20},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(500)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Pong","system")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Send("Pong", new int[] {11,4,11,33},
						new Performative("request"),
						new Variable(Type.STRING, "sender"),
						new Predicate("ping", new Term[] {})
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
			astra.core.Agent agent = new Pong().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
