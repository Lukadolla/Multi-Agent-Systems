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


public class HelloAll extends ASTRAClass {
	public HelloAll() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"HelloAll", new int[] {10,7,10,26},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"HelloAll", new int[] {10,25,10,41},
				new Statement[] {
					new Subgoal(
						"HelloAll", new int[] {10,27,10,41},
						new Goal(
							new Predicate("greetAll", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"HelloAll", new int[] {11,7,11,53},
			new GoalEvent('+',
				new Goal(
					new Predicate("greetAll", new Term[] {})
				)
			),
			new AND(
				new Predicate("knows", new Term[] {
					new Variable(Type.STRING, "X",false)
				}),
				new NOT(
					new Predicate("greeted", new Term[] {
						new Variable(Type.STRING, "X")
					})
				)
			),
			new Block(
				"HelloAll", new int[] {11,52,15,3},
				new Statement[] {
					new ModuleCall("console",
						"HelloAll", new int[] {12,4,12,40},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Hello, "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "X"),
									Primitive.newPrimitive("!")
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("HelloAll","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('+',
						"HelloAll", new int[] {13,4,15,3},
						new Predicate("greeted", new Term[] {
							new Variable(Type.STRING, "X")
						})
					),
					new Subgoal(
						"HelloAll", new int[] {14,4,15,3},
						new Goal(
							new Predicate("greetAll", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"HelloAll", new int[] {16,7,16,21},
			new GoalEvent('+',
				new Goal(
					new Predicate("greetAll", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"HelloAll", new int[] {16,20,16,23},
				new Statement[] {
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("knows", new Term[] {
				Primitive.newPrimitive("Rem")
			})
		);
		agent.initialize(
			new Predicate("knows", new Term[] {
				Primitive.newPrimitive("Fred")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
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
			astra.core.Agent agent = new HelloAll().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
