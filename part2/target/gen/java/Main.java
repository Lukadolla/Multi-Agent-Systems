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


public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"Main", new int[] {4,7,4,26},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {4,25,16,3},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"Main", new int[] {5,4,16,3},
						Primitive.newPrimitive(0)
					),
					new Declaration(
						new Variable(Type.LIST, "l"),
						"Main", new int[] {6,4,16,3},
						new ListTerm(new Term[] {

						})
					),
					new While(
						"Main", new int[] {8,4,16,3},
						new Comparison("<",
							new Variable(Type.INTEGER, "i"),
							Primitive.newPrimitive(10)
						),
						new Block(
							"Main", new int[] {8,17,13,5},
							new Statement[] {
								new ModuleCall("system",
									"Main", new int[] {9,7,9,45},
									new Predicate("createAgent", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("ping"),
											new Variable(Type.INTEGER, "i")
										),
										Primitive.newPrimitive("Ping")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Main","system")).createAgent(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								),
								new Declaration(
									new Variable(Type.STRING, "temp"),
									"Main", new int[] {10,7,13,5},
									Operator.newOperator('+',
										Primitive.newPrimitive("ping"),
										new Variable(Type.INTEGER, "i")
									)
								),
								new Assignment(
									new Variable(Type.LIST, "l"),
									"Main", new int[] {11,7,13,5},
									Operator.newOperator('+',
										new Variable(Type.LIST, "l"),
										new ListTerm(new Term[] {
											new Variable(Type.STRING, "temp")
										})
									)
								),
								new Assignment(
									new Variable(Type.INTEGER, "i"),
									"Main", new int[] {12,7,13,5},
									Operator.newOperator('+',
										new Variable(Type.INTEGER, "i"),
										Primitive.newPrimitive(1)
									)
								)
							}
						)
					),
					new ModuleCall("system",
						"Main", new int[] {14,4,14,38},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("pong"),
							Primitive.newPrimitive("Pong")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {15,4,15,33},
						new Predicate("setMainGoal", new Term[] {
							Primitive.newPrimitive("pong"),
							new Variable(Type.LIST, "l")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("system",astra.lang.System.class,agent);
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
			astra.core.Agent agent = new Main().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
