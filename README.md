# Pjatk TAU

# LAB5

## Trial
Trial is Twisted's unit testing system, an extension of Python's `unittest` https://docs.python.org/3/library/unittest.html module for asynchronous and event-driven code.

## Instalation
Trial is a core component of Twisted. As such, there is no need to download it separately. If you have downloaded the Twisted tarball, you'll find the Trial source code in the twisted/trial directory.

## Test sample
Trial is two things. The first is a command-line test runner, which can be run on plain Python unit tests.
It's very simple to use. For example, the fastest way to get going with Trial is to write a plain Python unit test like this:
```python
import unittest
class DemoTest(unittest.TestCase):
    def test_passes(self):
        pass
    def test_fails(self):
        self.fail("I failed.")
```
and then run it, like this:

```python
$ trial test_sample.py 
test_sample
  DemoTest
    test_fails ...                                                       [FAIL]
    test_passes ...                                                        [OK]

===============================================================================
[FAIL]
Traceback (most recent call last):
  File "unittest/case.py", line 318, in run
    testMethod()
  File "test_sample.py", line 9, in test_fails
    self.fail("I failed.")
  File "unittest/case.py", line 393, in fail
    raise self.failureException(msg)
exceptions.AssertionError: I failed.

test_sample.DemoTest.test_fails
-------------------------------------------------------------------------------
Ran 2 tests in 0.316s

FAILED (failures=1, successes=1)
```

Trial's test runner can do automated unit-test discovery across files, modules, or even arbitrarily nested packages. For example, you can run Twisted's own tests with it by just typing trial twisted in a shell.

Trial's test runner will also automatically catch errors that are logged but not ?explicitly handled. For example, this test will fail:
``` python
from twisted.python import log
import unittest
class DemoTest(unittest.TestCase):
    def test_failWithLog(self):
        try:
            1 / 0
        except:
            log.err()
```
Trial will also catch certain types of global state manipulations, like leaving stale sockets around in the global Twisted reactor, and fail tests as a result.

For a more complete list of the test runner's features, trial --help will provide options. A selection of features which can be enabled with these options include:

- Colored output: red for failure, green for success (even on Windows!)
- support for the subunit test-result protocol
- command-line control over the garbage collector (optionally collect between each test, or disable it)
- test-order randomization, based on a random seed so the same order can be repeated
- run your tests in a loop until they fail
- produce coverage reports
- real-time error reporting and traceback logging - useful for when your tests hang!
- run your tests under PDB and automatically break into the debugger on failure
- Trial also provides a plug-in interface for customizing and recording the output of test runs. You can type trial --help-reporters for more information about the plugins that are available on your system.

In addition to the test runner, Trial also includes a test library, derived from Python's unittest.TestCase.

The main unique feature of this testing class is the ability to return a Deferred from a test-case method. A test method which returns a Deferred will not complete until that Deferred has fired; the reactor will be automatically set up and run for you, along with a timeout to make sure that tests don't run forever. If the Deferred fires successfully, the test passes. If it fires with an error, the test fails. This makes it possible to easily unit-test asynchronous event-driven code, or to use Twisted APIs that return Deferreds in order to write automated functional tests that communicate with a live running service.


## Documentation
You can find a documentation here: https://twistedmatrix.com/documents/current/core/howto/trial.html

If you run trial --help from the command line, you'll see a list of possible invocation arguments (the trial command can be found in bin in the tarball).
